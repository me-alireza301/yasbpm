package org.pdecodts.yasb.engine;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.pdecodts.yasb.model.Node;
import org.pdecodts.yasb.model.OutputEventType;
import org.pdecodts.yasb.model.Transition;
import org.pdecodts.yasb.model.dynamic.TransitionGuardEvaluator;
import org.pdecodts.yasb.model.dynamic.TransitionTraversalEvaluator;

public class TransitionProcessor {
    private static Log log = LogFactory.getLog(TransitionProcessor.class);

    /**
     * Select method is in charge if a transition is elligible to be traversed.
     * A transition is elligible to be traversed if:
     * <ul>
     * <li>there is no guard constraining traversal condition</li>
     * <li>there is a guard and its evaluation authorize the traversal</li>
     * </ul>
     * 
     * @param ctx
     *            the processing context
     * @param transition
     *            the transition to select
     * @return true if the transition can be traversed false otherwise.
     */
    public boolean select(ProcessingContext ctx, Transition transition) {
	boolean res = true;
	TransitionGuardEvaluator guard = transition.getGuard();
	if (guard != null) {
	    log.info("evaluating guard for transition ' "
		    + transition.getName() + "'");
	    res = guard.validate(ctx, transition);
	    log.info("evaluating result of guard for transition ' "
		    + transition.getName() + "' is" + res);
	} else {
	    log.info("no guard to evaluate for transition ' "
		    + transition.getName() + "'selection result is true");
	}
	return res;
    }

    /**
     * Traverse the transition the transition target node.
     * 
     * @param ctx
     *            the processing context
     * @param transition
     *            the transition to be traversed
     * @return the transition target node.
     */
    public Node processTransition(ProcessingContext ctx, Transition transition) {
	traverse(ctx, transition);
	return transition.getTarget();
    }

    /**
     * Traverse the transition:
     * <ul>
     * <li>fire the action if an action is associated to the transition</li>
     * <li>generate and post event if an event to post is associated to the
     * transition</li>
     * 
     * @param ctx
     *            the processing context
     * @param transition
     *            the transition to traverse
     */
    private void traverse(ProcessingContext ctx, Transition transition) {
	OutputEventType eventType = transition.getTraversalNotifiedEventType();
	TransitionTraversalEvaluator action = transition.getAction();
	if (action != null) {
	    log.info("processing action for transition ' "
		    + transition.getName() + "' traversal");
	    action.process(ctx, transition);
	    log.info("processing action for transition ' "
		    + transition.getName() + "' traversal");
	} else {
	    log.info("no action to process for transition ' "
		    + transition.getName() + "' traversal");
	}
	try {

	    if (eventType != null) {
		log.info(" generating event '" + eventType
			+ "' for transition ' " + transition.getName()
			+ "' traversal");
		ctx.generateTransitionEvent(eventType, transition);

		log.info(" event  '" + eventType
			+ "' generated for transition ' "
			+ transition.getName() + "' traversal");
	    } else {
		log.info("no event to generate for transition ' "
			+ transition.getName() + "' traversal");
	    }
	} catch (Exception e) {
	    log.error(" failed to generated event");
	}
    }
}

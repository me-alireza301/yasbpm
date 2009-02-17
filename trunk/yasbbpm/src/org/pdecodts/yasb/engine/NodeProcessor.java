/**
 * 
 */
package org.pdecodts.yasb.engine;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.pdecodts.yasb.model.Node;
import org.pdecodts.yasb.model.NodeState;
import org.pdecodts.yasb.model.Transition;

/**
 * 
 * NodeProcessor is the part of the YASB engine in charge to process node.
 * 
 * @author pdecodts
 * 
 */
public class NodeProcessor {
    private static final Log log = LogFactory.getLog(NodeProcessor.class);

    public void leaveNode(ProcessingContext ctx, Node toLeave) {
	List<Node> currentLeavingCycle = new ArrayList<Node>();
	currentLeavingCycle.add(toLeave);
	leaveNodes(ctx, currentLeavingCycle);
    }

    public void leaveNodes(ProcessingContext ctx, List<Node> currentLeavingCycle) {

	while (!currentLeavingCycle.isEmpty()) {
	    currentLeavingCycle.addAll(0, ctx.processReceivedEvents());
	    if (ctx.isTerminated()) {
		log
			.info("context processing is terminated - stopping node leaving process ");
		break;
	    }
	    currentLeavingCycle = leavingCycle(ctx, currentLeavingCycle);

	}
    }

    public List<Node> leavingCycle(ProcessingContext ctx,
	    List<Node> leavingNodes) {
	List<Node> nextLeavingCycleNodes = new ArrayList<Node>();
	for (Node node : leavingNodes) {
	    nextLeavingCycleNodes.addAll(this.nextNodes(ctx, node));
	    if (ctx.isTerminated()) {
		log
			.info("context processing is terminated - stopping node leaving cycle ");
		break;
	    }
	}
	return nextLeavingCycleNodes;

    }

    /**
     * Process the node leaving step. The process is done as following:
     * <ul>
     * <li>gather all transition outgoing from the node to leave</li>
     * <li>for each gathered check if transition can be travesed</li>
     * <li>for each transition that can be traversed, gather the target node and
     * start it</li>
     * <li>in case of node processing is finished keep the node in the result
     * list as a node to leave in next node for next node leaving cycle</li>
     * </ul>
     * 
     * @param ctx
     *            the procesing context
     * @param toLeave
     *            the node to leave
     * @return a collection of nodes to leave
     */
    public List<Node> nextNodes(ProcessingContext ctx, Node toLeave) {

	/** create a transition processor */
	TransitionProcessor transProcessor = new TransitionProcessor();
	/** gather node outgoing transitions */
	List<Transition> nextTransitions = toLeave.getOugoingTransitions();
	/**
	 * list of transition that will have to be traversed after transition
	 * selection phase
	 */
	List<Transition> retainedTransitions = new ArrayList<Transition>();

	/** Transition selection phase */

	for (Transition transition : nextTransitions) {

	    if (transProcessor.select(ctx, transition)) {
		/** transition should be traversed */
		log.debug(String.format(
			"retain transition '%s' has to be traversed ",
			transition.getName()));
		retainedTransitions.add(transition);
	    }
	}

	/**
	 * traverse all transition resulting from selection phase and keep
	 * target nodes to start
	 */
	List<Node> newNodes = new ArrayList<Node>();
	for (Transition transition : retainedTransitions) {
	    log.debug(String.format("process transition '%s' to traverse",
		    transition.getName()));
	    Node newTargetNode = transProcessor.processTransition(ctx,
		    transition);
	    log.debug(String.format("retain node '%s' to start", newTargetNode
		    .getName()));
	    newNodes.add(newTargetNode);
	}

	/**
	 * start each traversed transition target node
	 */
	return startNodes(ctx, newNodes);

    }

    /**
     * 
     * @param ctx
     *            the processing context
     * @param nodeToStart
     *            the collection of node to start
     * @return return the collection of nodes that have to be left.
     */
    private List<Node> startNodes(ProcessingContext ctx, List<Node> nodesToStart) {
	List<Node> nodesToLeave = new ArrayList<Node>();
	for (Node node : nodesToStart) {
	    log.debug(String.format("start node '%s' ", node.getName()));
	    if (node.start(ctx) == NodeState.TerminatedState) {
		log
			.debug(String
				.format(
					"node '%s' is terminated and should be process in next processing cycle",
					node.getName()));
		nodesToLeave.add(node);
	    } else {
		log.debug(String.format("node is '%s' in waiting mode", node
			.getName()));
	    }
	    if (ctx.isTerminated()) {
		log
			.info("context processing is terminated - stopping node processing ");
		break;
	    }
	}
	return nodesToLeave;
    }

    public void iniateProcess(ProcessingContext ctx, List<Node> startingNodes) {
	List<Node> nodeToLeaves = startNodes(ctx, startingNodes);
	leaveNodes(ctx, nodeToLeaves);
    }
}

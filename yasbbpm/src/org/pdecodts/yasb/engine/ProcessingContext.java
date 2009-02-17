package org.pdecodts.yasb.engine;

import java.util.ArrayList;
import java.util.List;

import org.pdecodts.yasb.model.Node;
import org.pdecodts.yasb.model.OutputEventType;
import org.pdecodts.yasb.model.Transition;

public class ProcessingContext {
    private Object data;
    private BusinessProcessInstance processInstance;
    private boolean isTerminated;

    /**
     * @param eventType
     *            type of event
     * @param transition
     *            transition for wich the event is generated
     * @throws Exception
     *             in case of problem
     */
    public void generateTransitionEvent(OutputEventType eventType,
	    Transition transition) throws Exception {
	BusinessProcessEvent event = new BusinessProcessEvent(
		BusinessProcessEventType.TransitionRelated);
	event.setSubject(processInstance.getModel(), processInstance.getId(),
		transition.getName());
	postEvent(event);
    }

    private void postEvent(BusinessProcessEvent event) {
	// TODO Auto-generated method stub

    }

    /**
     * @return
     */
    public boolean isTerminated() {
	// TODO Auto-generated method stub
	return false;
    }

    /**
     * ProcessQueueEvent against waiting node and returns node that have to be
     * leaved.
     * 
     * @return the list of nodes that have to be leaved.
     */
    public List<Node> processReceivedEvents() {
	List<Node> awakenNodes = new ArrayList<Node>();
	return awakenNodes;
    }

}

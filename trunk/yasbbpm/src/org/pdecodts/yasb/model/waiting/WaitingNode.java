package org.pdecodts.yasb.model.waiting;

import org.pdecodts.yasb.engine.ProcessingContext;
import org.pdecodts.yasb.model.InputEventType;
import org.pdecodts.yasb.model.Node;

public abstract class WaitingNode extends Node {

    InputEventType relatedEvent;

    /*
     * (non-Javadoc)
     * 
     * @see com.pdecodts.yasb.model.Node#isWaitingNode()
     */
    @Override
    protected boolean isWaitingNode() {

	return true;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.pdecodts.yasb.model.Node#requiresEvaluation()
     */
    @Override
    protected boolean isRequiredEvaluation() {
	return false;
    }

    public void start(ProcessingContext ctx) {

    }

}

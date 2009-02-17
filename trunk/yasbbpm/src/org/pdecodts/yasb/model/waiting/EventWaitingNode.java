package org.pdecodts.yasb.model.waiting;

public class EventWaitingNode extends WaitingNode {

    @Override
    protected boolean isMulitleIncomingTransitionSupported() {
	return true;
    }

    @Override
    protected boolean isMulitleOutgoingTransitionSupported() {
	return false;
    }
}

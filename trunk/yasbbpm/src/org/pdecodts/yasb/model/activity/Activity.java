package org.pdecodts.yasb.model.activity;

import org.pdecodts.yasb.model.Node;

public class Activity extends Node {

    @Override
    protected boolean isMulitleIncomingTransitionSupported() {
	return true;
    }

    @Override
    protected boolean isMulitleOutgoingTransitionSupported() {
	return true;
    }

    @Override
    protected boolean isRequiredEvaluation() {
	return false;
    }

    @Override
    protected boolean isWaitingNode() {
	return true;
    }

}

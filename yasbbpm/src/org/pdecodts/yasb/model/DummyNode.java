package org.pdecodts.yasb.model;

class DummyNode extends Node {

	
	DummyNode( String name) {
		super.setName(name) ;
	}
	@Override
	protected boolean isMulitleIncomingTransitionSupported() {
		return false;
	}

	@Override
	protected boolean isMulitleOutgoingTransitionSupported() {
		return false;
	}
	@Override
	protected boolean isRequiredEvaluation() {
		
		return false;
	}
	@Override
	protected boolean isWaitingNode() {
		
		return false;
	}

}

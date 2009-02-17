package org.pdecodts.yasb.model.gateway;

import org.pdecodts.yasb.model.Node;



public abstract class GatewayNode extends Node {

	/* (non-Javadoc)
	 * @see com.pdecodts.yasb.model.Node#isMulitleIncomingTransitionSupported()
	 */
	@Override
	protected boolean isMulitleIncomingTransitionSupported() {
		
		return true;
	}

	/* (non-Javadoc)
	 * @see com.pdecodts.yasb.model.Node#isMulitleOutgoingTransitionSupported()
	 */
	@Override
	protected boolean isMulitleOutgoingTransitionSupported() {
		return true;
	}

	/* (non-Javadoc)
	 * @see com.pdecodts.yasb.model.Node#isRequiredEvaluation()
	 */
	@Override
	protected boolean isRequiredEvaluation() {
		return false;
	}

	/* (non-Javadoc)
	 * @see com.pdecodts.yasb.model.Node#isWaitingNode()
	 */
	@Override
	protected boolean isWaitingNode() {
		return false;
	}

}

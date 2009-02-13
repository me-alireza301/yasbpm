/**
 * 
 */
package org.pdecodts.yasbpm.model.gateway;

import org.pdecodts.yasbpm.model.processmodel.Node;

/**
 * @author xsipds
 *
 */
public class InclusiveGateway extends Node {

    /* (non-Javadoc)
     * @see org.pdecodts.yasbpm.model.processmodel.Node#supportMultipleIncominTransition()
     */
    @Override
    public boolean supportMultipleIncominTransition() {
        return true;
    }

    /* (non-Javadoc)
     * @see org.pdecodts.yasbpm.model.processmodel.Node#supportMultipleOutgoingTransition()
     */
    @Override
    public boolean supportMultipleOutgoingTransition() {
        return false;
    }

}

/**
 * 
 */
package org.pdecodts.yasbpm.model.gateway;

import org.pdecodts.yasbpm.model.processmodel.Node;

/**
 * @author xsipds
 *
 */
public class ParallelGateway extends Node {

    /* (non-Javadoc)
     * @see org.pdecodts.yasbpm.model.processmodel.Node#supportMultipleIncominTransition()
     */
    @Override
    public boolean supportMultipleIncominTransition() {
        return false;
    }

    /* (non-Javadoc)
     * @see org.pdecodts.yasbpm.model.processmodel.Node#supportMultipleOutgoingTransition()
     */
    @Override
    public boolean supportMultipleOutgoingTransition() {
        return true;
    }
    
}

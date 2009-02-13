/**
 * 
 */
package org.pdecodts.yasbpm.model.activity;

import org.pdecodts.yasbpm.model.processmodel.Node;

/**
 * @author xsipds
 *
 */
public class Activity extends Node {

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
        // TODO Auto-generated method stub
        return true;
    }
}

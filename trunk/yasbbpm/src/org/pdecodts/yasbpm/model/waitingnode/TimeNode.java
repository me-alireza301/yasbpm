/**
 * 
 */
package org.pdecodts.yasbpm.model.waitingnode;

import org.pdecodts.yasbpm.model.processmodel.Node;

/**
 * @author xsipds
 *
 */
public class TimeNode extends Node {
    private long timeOut ;

    public long getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(long timeOut) {
        this.timeOut = timeOut;
    }

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
        return false;
    }
    
}

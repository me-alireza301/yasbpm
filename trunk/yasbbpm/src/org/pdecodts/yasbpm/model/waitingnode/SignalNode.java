/**
 * 
 */
package org.pdecodts.yasbpm.model.waitingnode;

import org.pdecodts.yasbpm.model.communication.EventListener;
import org.pdecodts.yasbpm.model.processmodel.Node;

/**
 * @author xsipds
 *
 */
public class SignalNode extends Node {
    private EventListener listener ;

    public EventListener getListener() {
        return listener;
    }

    public void setListener(EventListener listener) {
        this.listener = listener;
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

/**
 * 
 */
package org.pdecodts.yasbpm.model.processmodel;

import java.util.ArrayList;
import java.util.List;

import org.pdecodts.yasbpm.model.communication.InputChannel;
import org.pdecodts.yasbpm.model.communication.OutputChannel;

/**
 * @author xsipds
 *
 */
public class ProcessModel {
    String name ;
    List<Role>  requiredRoles = new ArrayList<Role> () ;
    List<InputChannel> inputChannels =  new ArrayList<InputChannel> () ;
    List<OutputChannel> outputChannels =  new ArrayList<OutputChannel> () ;
}

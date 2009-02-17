package org.pdecodts.yasb.model;

import org.pdecodts.yasb.model.dynamic.TransitionGuardEvaluator;
import org.pdecodts.yasb.model.dynamic.TransitionTraversalEvaluator;

/**
 * A Transition define a path between to node of a process.
 * Consequently a Transition supports:
 * <ul>
 * <li> a source node : the node from where the transition start </li>
 * <li> a target node : the node to where the tranisiton arrives </li>
 * </ul>
 * A transition support 3 kind of dynamic element evaluated before and during the transition traversal:
 * <ul>
 * <li> a transition guard : defining if the transition can be traversed </li>
 * <li> a transition action:  the action to be performed when the tansition has to be traversed </li>
 * <li> a output event type : an event to be emitted when the transition is traversed </li>
 * </ul>
 * 
 * @author pdecodts
 *
 */
public class Transition {

	/**
	 * target node of the transition.
	 * This element is mandatory for a transition to be valid.
	 */
	private Node target ;
	/**
	 * source node of the transition.
	 * This element is mandatory for a transition to be valid.
	 */
	private Node source ;
	
	/**
	 * The business process the transition belongs to.
	 * This element is mandatory for a transition to be valid. 
	 */
	private BusinessProcess container ;
	/**
	 * name of the transition.
	 * This element is mandatory. Furhtermore the name of the transition should be unique on all the transition  in the scope of its business process since this name identified in a unique manner the transition overall the transitions support by a business process model container.
	 */
	private String name ;
	
	/**
	 * The guard of the transition.
	 * Guard of the transition defines a conditional dynamic evaluator that verifies at transition traversal time if the transition can be traversed.
	 * Guard is optional, meaning that if there is no guard associated to the transition, the transition is elligible at any time to be traversed. 
	 */
	private TransitionGuardEvaluator guard ;
	/**
	 * The action of the transition.
	 * Action of the transition defined a dynamic evaluator that is triggered when the transition is traversed.
	 */
	private TransitionTraversalEvaluator action ;
	
	/**
	 *  The traversalNotifiedEventType defines an event to be posted when the transition is traversed
	 */
	private OutputEventType traversalNotifiedEventType; 
	
	/**
	 * @return the guard
	 */
	public TransitionGuardEvaluator getGuard() {
		return guard;
	}
	/**
	 * @param guard the guard to set
	 */
	public void setGuard(TransitionGuardEvaluator guard) {
		this.guard = guard;
	}
	/**
	 * @return the action
	 */
	public TransitionTraversalEvaluator getAction() {
		return action;
	}
	/**
	 * @param action the action to set
	 */
	public void setAction(TransitionTraversalEvaluator action) {
		this.action = action;
	}
	/**
	 * @return the traversalNotifiedEventType
	 */
	public OutputEventType getTraversalNotifiedEventType() {
		return traversalNotifiedEventType;
	}
	/**
	 * @param traversalNotifiedEventType the traversalNotifiedEventType to set
	 */
	public void setTraversalNotifiedEventType(
			OutputEventType traversalNotifiedEventType) {
		this.traversalNotifiedEventType = traversalNotifiedEventType;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the target
	 */
	public Node getTarget() {
		return target;
	}
	/**
	 * @param target the target to set
	 */
	public void setTarget(Node target) {
		this.target = target;
	}
	/**
	 * @return the source
	 */
	public Node getSource() {
		return source;
	}
	/**
	 * @param source the source to set
	 */
	public void setSource(Node source) {
		this.source = source;
	}
}

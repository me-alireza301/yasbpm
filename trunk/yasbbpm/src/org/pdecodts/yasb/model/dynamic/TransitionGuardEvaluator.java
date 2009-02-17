package org.pdecodts.yasb.model.dynamic;

import org.pdecodts.yasb.engine.ProcessingContext;
import org.pdecodts.yasb.model.Transition;


public interface TransitionGuardEvaluator extends TransitionEvaluator {
	boolean validate(ProcessingContext ctx, Transition transition) ;
}

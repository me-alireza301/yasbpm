package org.pdecodts.yasb.model.dynamic;

import org.pdecodts.yasb.engine.ProcessingContext;
import org.pdecodts.yasb.model.Transition;


public interface TransitionTraversalEvaluator extends TransitionEvaluator {

	void process(ProcessingContext ctx, Transition transition);

}

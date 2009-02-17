package org.pdecodts.yasb.engine;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.pdecodts.yasb.model.BusinessProcess;
import org.pdecodts.yasb.util.Asserter;

/**
 * BusinessProcessEvent defines information enabling to define a event entering
 * or leavind inside the business process. A Business process event
 * 
 * @author pdecodts
 * 
 */
public class BusinessProcessEvent {

    /**
     * class logger
     */
    private final static Log log = LogFactory
	    .getLog(BusinessProcessEvent.class);

    // -------------- Warning error codes ----------------------
    private static final String NullTypeWarnCode = "BPEVT-W1";
    private static final String NullSubjectWarnCode = "BPEVT-W2";
    private static final String InvalidSubjectWarnCode = "BPEVT-W3";

    // -------------- Precondition error codes ----------------------
    private static final String NullTypeErrorCode = "BPEVT-E1";
    private static final String InvalidSubjectErrorCode = "BPEVT-E2";

    /**
     * event type.
     */
    private BusinessProcessEventType type;
    /**
     * event subject
     */
    private BusinessProcessEventSubject subject;
    /**
     * event content
     */
    private String message;

    /**
     * @return the message
     */
    public String getMessage() {
	return message;
    }

    /**
     * @param message
     *            the message to set
     */
    public void setMessage(String message) {
	this.message = message;
    }

    /**
     * @param type
     * @throws Exception
     */
    public BusinessProcessEvent(BusinessProcessEventType type) throws Exception {
	Asserter.precondition(log, type != null, NullPointerException.class,
		"cannot create BusinessProcessEvent with null type",
		NullTypeErrorCode);
	this.type = type;

    }

    public void setSubject(BusinessProcess model, Object processId,
	    String elementName) throws Exception {
	subject = new BusinessProcessEventSubject(model.getName(), model
		.getId(), processId, elementName);
	Asserter.postcondition(log, subject.isValid(), Exception.class,
		"invalid subject", InvalidSubjectErrorCode);

    }

    /**
     * @return the type
     */
    public final BusinessProcessEventType getType() {
	return type;
    }

    /**
     * @return the subject
     */
    public final BusinessProcessEventSubject getSubject() {
	return subject;
    }

    public boolean isValid() {
	return (Asserter.assertNotNull(log, type,
		"type is null for BusinessProcessEvent", NullTypeWarnCode)
		&& Asserter.assertNotNull(log, subject,
			"subject is null for BusinessProcessEvent",
			NullSubjectWarnCode) && Asserter.assertTrue(log,
		subject.isValid(), "subject invalid", InvalidSubjectWarnCode));

    }

}

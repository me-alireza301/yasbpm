/**
 * 
 */
package org.pdecodts.yasb.util;

import java.util.Collection;

import org.apache.commons.logging.Log;

/**
 * Utility class enabling to verfiy assertions.
 * 
 * @author pdecodts
 */
public class Asserter {
    private final static String PrecondMessage = "Precondition violation : %s";
    private final static String PostcondMessage = "Postcondition violation : %s";
    private final static String AssertMessage = "Assertion %s not verfied : %s";
    private final static String ErrorPrefix = "Error '%d' -";
    private final static String WarningPrefix = "Warning '%d' - ";

    /**
     * Precondition check
     * 
     * @param logger
     *            the logger to be used when the precondition is not verified
     * @param condition
     *            the condition evaluation result
     * @param class1
     *            the exception to throw when the condition is not observed
     * @param message
     *            the application message to incorporated into the trace
     * @param code
     *            the error code
     * @throws Exception
     *             the exception dynamically
     */
    public static void precondition(Log logger, boolean condition,
	    Class<? extends Exception> ec, String message, Object code)
	    throws Exception {
	if (!condition) {

	    String emessage = String.format(ErrorPrefix + PrecondMessage,
		    code != null ? code.toString() : "no-code", message);
	    logger.error(emessage);
	    Exception e = ec.getConstructor(String.class).newInstance(emessage);
	    throw e;
	}
    }

    /**
     * Postcondition check
     * 
     * @param logger
     *            the logger to be used when the precondition is not verified
     * @param condition
     *            the condition evaluation result
     * @param ec
     *            the exception to throw when the condition is not observed
     * @param message
     *            the application message to incorporated into the trace
     * @param code
     *            the error code
     * @throws Exception
     *             the exception dynamically
     */
    public static void postcondition(Log logger, boolean condition,
	    Class<? extends Exception> ec, String message, Object code)
	    throws Exception {
	if (!condition) {

	    String emessage = String.format(ErrorPrefix + PostcondMessage,
		    code != null ? code.toString() : "no-code", message);
	    logger.error(emessage);
	    Exception e = ec.getConstructor(String.class).newInstance(emessage);
	    throw e;
	}
    }

    /**
     * Assert that a condition is observed.
     * 
     * @param logger
     *            the logger to log the assertion violation
     * @param condition
     *            the condition that have to be observed
     * @param message
     *            the message to be trace in case of assertion violation
     * @param code
     *            the code corresponding to the assertion violation
     * @return true if assertion is verified, false otherwise
     */
    public static boolean assertTrue(Log logger, boolean condition,
	    String message, Object code) {
	return assertTrue(logger, "assertTrue", condition, message, code);
    }

    /**
     * Assert that a condition is not observed.
     * 
     * @param logger
     *            the logger to log the assertion violation
     * @param condition
     *            the condition that have to be observed
     * @param message
     *            the message to be trace in case of assertion violation
     * @param code
     *            the code corresponding to the assertion violation
     * @return true if assertion is verified, false otherwise
     */
    public static boolean assertFalse(Log logger, boolean condition,
	    String message, Object code) {
	return assertFalse(logger, "assertFalse", condition, message, code);
    }

    /**
     * Assert object is null.
     * 
     * @param logger
     *            the logger to log the assertion violation
     * @param object
     *            the the object that should be null
     * @param message
     *            the message to be trace in case of assertion violation
     * @param code
     *            the code corresponding to the assertion violation
     * @return true if assertion is verified, false otherwise
     */
    public static boolean assertNull(Log logger, Object object, String message,
	    Object code) {
	return assertTrue(logger, "assertNull", object == null, message, code);

    }

    /**
     * Assert object is not null.
     * 
     * @param logger
     *            the logger to log the assertion violation
     * @param object
     *            the the object that should be not null
     * @param message
     *            the message to be trace in case of assertion violation
     * @param code
     *            the code corresponding to the assertion violation
     * @return true if assertion is verified, false otherwise
     */
    public static boolean assertNotNull(Log logger, Object object,
	    String message, Object code) {
	return assertFalse(logger, "assertNotNull", object == null, message,
		code);

    }

    /**
     * Assert that to objects are equals (semantically by the use of equals).
     * 
     * @param logger
     *            the logger to log the assertion violation
     * @param object1
     *            the first object that should be equals to the other
     * @param object2
     *            the second object that should be equals to the other
     * @param message
     *            the message to be trace in case of assertion violation
     * @param code
     *            the code corresponding to the assertion violation
     * @return true if assertion is verified, false otherwise
     */
    public static boolean assertEquals(Log logger, Object object1,
	    Object object2, String message, Object code) {
	return assertTrue(logger, "assertEquals", object1.equals(object2),
		message, code);
    }

    /**
     * Assert that to objects are not equals (semantically by the use of
     * equals).
     * 
     * @param logger
     *            the logger to log the assertion violation
     * @param object1
     *            the first object that should not be equals to the other
     * @param object2
     *            the second object that should not be equals to the other
     * @param message
     *            the message to be trace in case of assertion violation
     * @param code
     *            the code corresponding to the assertion violation
     * @return true if assertion is verified, false otherwise
     */
    public static boolean assertNotEquals(Log logger, Object object1,
	    Object object2, String message, Object code) {
	return assertFalse(logger, "assertNotEquals", object1.equals(object2),
		message, code);
    }

    /**
     * Assert that to objects are the same (physically by the use of ==).
     * 
     * @param logger
     *            the logger to log the assertion violation
     * @param object1
     *            the first object that should be the same to the other
     * @param object2
     *            the second object that should be the same to the other
     * @param message
     *            the message to be trace in case of assertion violation
     * @param code
     *            the code corresponding to the assertion violation
     * @return true if assertion is verified, false otherwise
     */
    public static boolean assertSame(Log logger, Object object1,
	    Object object2, String message, Object code) {
	return assertTrue(logger, "assertSame", object1 == object2, message,
		code);
    }

    /**
     * Assert that to objects are not the same (physically by the use of !=).
     * 
     * @param logger
     *            the logger to log the assertion violation
     * @param object1
     *            the first object that should not be the same to the other
     * @param object2
     *            the second object that should not be the same to the other
     * @param message
     *            the message to be trace in case of assertion violation
     * @param code
     *            the code corresponding to the assertion violation
     * @return true if assertion is verified, false otherwise
     */
    public static boolean assertNotSame(Log logger, Object object1,
	    Object object2, String message, Object code) {
	return assertFalse(logger, "assertNotSame", object1 != object2,
		message, code);
    }

    /**
     * Assert that to a collection is empty.
     * 
     * @param logger
     *            the logger to log the assertion violation
     * @param collection
     *            the collection that should be empty
     * @param message
     *            the message to be trace in case of assertion violation
     * @param code
     *            the code corresponding to the assertion violation
     * @return true if assertion is verified, false otherwise
     */
    public static boolean assertEmpty(Log logger, Collection<?> collection,
	    String message, Object code) {
	return assertTrue(logger, "assertEmpty", collection.isEmpty(), message,
		code);
    }

    /**
     * Assert that to a collection is not empty.
     * 
     * @param logger
     *            the logger to log the assertion violation
     * @param collection
     *            the collection that should not be empty
     * @param message
     *            the message to be trace in case of assertion violation
     * @param code
     *            the code corresponding to the assertion violation
     * @return true if assertion is verified, false otherwise
     */
    public static boolean assertNotEmpty(Log logger, Collection<?> collection,
	    String message, Object code) {
	return assertFalse(logger, "assertNotEmpty", collection.isEmpty(),
		message, code);
    }

    private static boolean assertFalse(Log logger, String assertionType,
	    boolean condition, String message, Object code) {
	if (!condition) {

	    String emessage = String.format(WarningPrefix + AssertMessage,
		    code != null ? code.toString() : "no-code", assertionType,
		    message);
	    logger.warn(emessage);

	}
	return condition == false;
    }

    private static boolean assertTrue(Log logger, String assertionType,
	    boolean condition, String message, Object code) {
	if (condition) {

	    String emessage = String.format(WarningPrefix + AssertMessage,
		    code != null ? code.toString() : "no-code", assertionType,
		    message);
	    logger.warn(emessage);

	}
	return condition == false;
    }

}

package com.code.fox.chatterfox.data;

import java.util.HashMap;
//bumped off of demo-web-project
/**
 * This class is a HashMap, but we extend the HashMap
 * class so that we can rename it to something meaningful.
 * <p>
 * Basically, the key of the map is the user ID, and the
 * value is the actual User object.
 *
 */
@SuppressWarnings("serial")
public class UserMap extends HashMap<String, User> {

}

package org.osiam.addons.administration.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

/**
 * Generic controller with common functionality.
 */
public abstract class GenericController {

    @Inject
    private HttpSession session;

    /**
     * Store an object into the session.
     * 
     * @param key Under which key should this object stored.
     * @param toStore Object that should be stored.
     */
    public void storeInSession(String key, Object toStore){
        session.setAttribute(generateKey(key), toStore);
    }

    /**
     * Get the object from the session.
     * 
     * @param key The key under which the object will be found.
     * @return The object if one was found under the given key. Otherwise <b>null</b>.
     */
    public Object restoreFromSession(String key){
        return session.getAttribute(generateKey(key));
    }

    /**
     * Remove the object from the session.
     * 
     * @param key The key under which the object will be found.
     */
    public void removeFromSession(String key){
        session.removeAttribute(generateKey(key));
    }

    private String generateKey(String key) {
        return getClass().getName() + key;
    }
}
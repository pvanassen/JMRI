package jmri.jmrit.logixng.string.implementation;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import jmri.InstanceManager;
import jmri.JmriException;
import jmri.jmrit.logixng.Base;
import jmri.jmrit.logixng.Category;
import jmri.jmrit.logixng.FemaleSocketListener;
import jmri.jmrit.logixng.FemaleStringActionSocket;
import jmri.jmrit.logixng.MaleStringActionSocket;
import jmri.jmrit.logixng.MaleSocket;
import jmri.jmrit.logixng.StringActionManager;
import jmri.jmrit.logixng.implementation.AbstractFemaleSocket;

/**
 * Default implementation of the Female String Action socket
 */
public final class DefaultFemaleStringActionSocket
        extends AbstractFemaleSocket
        implements FemaleStringActionSocket {

    public DefaultFemaleStringActionSocket(Base parent, FemaleSocketListener listener, String name) {
        super(parent, listener, name);
    }
    
    @Override
    public boolean isCompatible(MaleSocket socket) {
        return socket instanceof MaleStringActionSocket;
    }
    
    @Override
    public void setValue(String value) throws JmriException {
        if (isConnected()) {
            ((MaleStringActionSocket)getConnectedSocket()).setValue(value);
        }
    }

    @Override
    public String getShortDescription(Locale locale) {
        return Bundle.getMessage(locale, "DefaultFemaleStringActionSocket_Short");
    }

    @Override
    public String getLongDescription(Locale locale) {
        return Bundle.getMessage(locale, "DefaultFemaleStringActionSocket_Long", getName());
    }

    /** {@inheritDoc} */
    @Override
    public String getNewSystemName() {
        return InstanceManager.getDefault(StringActionManager.class).getAutoSystemName();
    }

    @Override
    public Map<Category, List<Class<? extends Base>>> getConnectableClasses() {
        return InstanceManager.getDefault(StringActionManager.class).getActionClasses();
    }

    /** {@inheritDoc} */
    @Override
    public void disposeMe() {
        // Do nothing
    }

}

package org.analyticbastard.hierarchicalstorage;

import clojure.java.api.Clojure;
import clojure.lang.IFn;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Created by javier on 10/10/15.
 */
public class HierarchicalStorage implements IHierarchicalStorage {

    final IFn require = Clojure.var("clojure.core", "require");

    final IHierarchicalStorage delegate;

    public HierarchicalStorage() {
        require.invoke();

        final IFn createHierarchicalStorage = Clojure.var("hierarchical-storage.core", "create-hierarchical-storage");
        delegate = (IHierarchicalStorage) createHierarchicalStorage.invoke();
    }

    @Override
    public void store(Collection<String> keyPath, String value) {
        delegate.store(keyPath, value);
    }

    @Override
    public void store(Map all) {
        delegate.store(all);
    }

    @Override
    public void store(String key, String value) {
        delegate.store(key, value);
    }

    @Override
    public String recall(Collection<String> keyPath) {
        return delegate.recall(keyPath);
    }

    public String recall(String key)
    {
        List<String> keyPath = new ArrayList<String>(1);
        keyPath.add(key);
        return delegate.recall(keyPath);
    }
}

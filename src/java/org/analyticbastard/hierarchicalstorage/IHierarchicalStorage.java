package org.analyticbastard.hierarchicalstorage;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Created by javier on 10/10/15.
 */

public interface IHierarchicalStorage {
    public void store (Collection<String> keyPath, String value);

    public void store (Map all);

    public void store (String key, String value);

    public String recall(List<String> keyPath);
}
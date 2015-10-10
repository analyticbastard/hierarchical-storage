# hierarchical-storage

Tree storage of string values under hierarchical key paths

```
key1
|
+- key2
|  |
|  +- ...
:  :    :
        + -> value
```

## Installation

Add this to your ```project.clj```

```clojure
[analyticbastard/hierarchical-storage "0.0.1-SNAPSHOT"]
```

## Usage

Require the library's main namespace from your namespace:

```clojure
(:require [hierarchical-storage :as storage])
```

Then use it:

```clojure
(def storage
  (storage/create-hierarchical-storage "/tmp/kk.edn"))

(.store storage ["level1" "level2"] "value")
```

## License

Copyright © 2015 Javier Arriero

[Eclipse Public License](http://www.eclipse.org/legal/epl-v10.html)


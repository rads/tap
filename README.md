# rads.tap

## Getting Started

Add `rads/tap` to `deps.edn`:

```clojure
{:deps {com.github.rads/tap {:git/url "https://github.com/rads/tap.git"
                             :git/sha "de29ea6" :git/tag "v0.1.0"}}}
```

Require `rads.tap` to enable `rads.tap/log`:

```clojure
; Load the library (includes a call to clojure.core/add-tap)
(require 'rads.tap)

; Send some messages
(doseq [x (range 1000)] (tap> x))

; By default, we only save the last 100 values in-memory
(count @rads.tap/log) ; => 100

; Values are ordered by timestamp in ascending order
(take-last 5 @rads.tap/log) ; => (995 996 997 998 999)

; Use the limit atom to change the size of the buffer
(reset! rads.tap/limit 1000)
```

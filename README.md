# rads.tap

Save `tap>` calls for debugging in the REPL.

## Usage

```clojure
; Load the library (includes a call to clojure.core/add-tap)
(require 'rads.tap)

; Send some messages
(doseq [x (range 1000)] (tap> x))

; By default, we only save the last 100 values in-memory
(count @rads.tap/log) ; => 100

; Values are ordered by insertion time in ascending order
(take-last 5 @rads.tap/log) ; => (995 996 997 998 999)

; Use the rads.tap/limit to change the size of the buffer
(rads.tap/limit 1000)
```

## Installation

### tools.deps

Add `io.github.rads/tap` to `deps.edn`:

```clojure
{:deps {io.github.rads/tap {:mvn/version "0.2.0"}}}
```

### Leiningen

Add `io.github.rads/tap` to `~/.lein/profiles.clj`:

```clojure
{:dependencies [[io.github.rads/tap "0.2.0"]]}
```

# clj-reflection

A small Clojure library for accessing private fields of java objects.

## Usage

You can create an accessible object from a java object by 'accesible' function.

```(def acc (accessible (Double 100.0)))```

then you can access private fields of the object contained in a newly created accessible object.

```(:value acc) ;; => 100.0```

## License

Copyright © 2016 Tsutomu YANO

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.

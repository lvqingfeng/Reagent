Reagent
=======

Experiments for future reactive libraries.

## `coroutines/`

**Simpler asynchrony and concurrency primitives.**

By leveraging the language and library coroutine support, the need for a custom lightweight job
scheduler and executor as well as concurrency primitives can be largely eliminated. Maintenance
costs for operators goes way down since imperative-looking code can be written.


## `multiplatform/`

**One API for multiple platforms. Also polymorphic stream types.**
 
Use the same reactive API and implementation in crossplatform code as well as natively inside
platform-specific code.

Polymorphic types mean that just like how every `List<T>` and `Set<T>` is a `Collection<T>`, every
`One<T>` is just a `Many<T>` with only a single element, etc.


### Type Hierarchy

                  +---------------+
                  |               |
                  |    Many<T>    |
                  |               |
                  +---------------+
                          ^
                          |
                  +-------+-------+
                  |               |
                  |    Maybe<T>   |
                  |               |
                  +---------------+
                     ^         ^
                     |         |
        +------------+--+   +--+-----------+
        |               |   |              |
        |    One<T>     |   |     Task     |
        |               |   |              |
        +---------------+   +--------------+



_Note: `coroutines/` and `multiplatform/` should be combined, but can't until Kotlin's coroutine
libraries are properly multiplatform._


FAQ
---

### Should I use this?

No.



License
-------

    Copyright 2016 Jake Wharton
    
    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at
    
       http://www.apache.org/licenses/LICENSE-2.0
    
    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

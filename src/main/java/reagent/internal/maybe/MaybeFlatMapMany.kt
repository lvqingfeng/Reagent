/*
 * Copyright 2016 Jake Wharton
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package reagent.internal.maybe

import reagent.Many
import reagent.Maybe

class MaybeFlatMapMany<U, D>(val upstream: Maybe<U>, val func: (U) -> Many<D>) : Many<D>() {
  override fun subscribe(listener: Listener<D>) = upstream.subscribe(Operator(listener, func))

  class Operator<U, D>(val downstream: Listener<D>, val func: (U) -> Many<D>) : Maybe.Listener<U> {
    override fun onItem(item: U) = func.invoke(item).subscribe(downstream)
    override fun onNothing() = downstream.onComplete()
    override fun onError(t: Throwable) = downstream.onError(t)
  }
}

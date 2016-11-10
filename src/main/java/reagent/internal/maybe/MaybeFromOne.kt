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

import reagent.Maybe
import reagent.One

class MaybeFromOne<U>(val upstream: One<U>) : Maybe<U>() {
  override fun subscribe(listener: Maybe.Listener<U>) = upstream.subscribe(
      Listener(listener))

  class Listener<U>(val delegate: Maybe.Listener<U>) : One.Listener<U> {
    override fun onItem(item: U) = delegate.onItem(item)
    override fun onError(t: Throwable) = delegate.onError(t)
  }
}

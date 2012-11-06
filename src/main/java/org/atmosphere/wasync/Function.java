/*
 * Copyright 2012 Jeanfrancois Arcand
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.atmosphere.wasync;

/**
 * A function is asynchronously invoked when a response is received, complete or not.
 *
 * This library supports predefined life cycle's events (@link #MESSAGE} that can be used. For example, a Function
 * can be defined for handling IOException:
 * <blockquote><pre>
 *
 *     class Function<IOException>() {
 *
 *         public void on(IOEXception ex) {
 *
 *         }
 *     }
 * </pre></blockquote>
 * This function can be registered using the {@link Socket#on(Function)} as
 * <blockquote><pre>
 *
 *     socket.on(new Function&lt;IOEXception&gt;() {
 *         ....
 *     }
 * </pre></blockquote>
 * This is the equivalent of doing
 * <blockquote><pre>
 *
 *     socket.on(MESSAGE.error, new Function&lt;IOEXception&gt;() {
 *         ....
 *     }
 * </pre></blockquote>
 * Anonymous functions call also be invoked if a {@link Decoder} match its type
 * <blockquote><pre>
 *
 *     socket
 *     .decoder(new Decoder&lt;String, POJO&gt;(){
 *         public POJO decode(String message) {
 *             return new POJO(message);
 *         }
 *     }
 *
 *     .on(new Function&lt;POJO&gt;() {
 *         ....
 *     }
 * </pre></blockquote>
 * @param <T>
 * @author Jeanfrancois Arcand
 */
public interface Function<T extends Object> {

    enum MESSAGE {error, open, close, message, status, headers, bytes}

    /**
     * A function that will be invoked when a
     * @param t
     */
    void on(T t);

}
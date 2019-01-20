/**
 * Copyright (c) 2019, Mihai Emil Andronache
 * All rights reserved.
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 1)Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the following disclaimer.
 * 2)Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 * 3)Neither the name of zold-java-client nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */
package com.amihaiemil.zold;

import com.amihaiemil.zold.exception.ZoldException;

import java.time.Duration;

/**
 * Zold network entry point.
 * @author Mihai Andronache (amihaiemil@gmail.com)
 * @version $Id$
 * @since 0.0.1
 */
public interface ZoldWts {

    /**
     * Initiate PULL request. The server will pull your wallet form the network,
     *  and make it ready for future request. Without this operation you won't
     *  be able to perform <tt>find()</tt> or <tt>balance()</tt> request.
     *
     * The method returns the job ID, which you should wait for completion
     *  using the method <tt>wait()</tt>.
     *
     * @return String Job Id.
     *
     * @throws ZoldException exception.
     */
    String pull() throws ZoldException;

    /**
     * Wait for the job to complete. If the job completes successfully, the
     *  method returns 'OK' in a few seconds (up to a few minutes). If the
     *  is some error, the exception will be raised.
     *
     * @param jobId Job Id.
     * @param timeout Duration timeout.
     * @throws ZoldException exception.
     */
    void waitForJob(String jobId, Duration timeout) throws ZoldException;

    /**
     * Get wallet id.
     *
     * @return Wallet id
     * @throws ZoldException exception.
     */
    String walletId() throws ZoldException;
}

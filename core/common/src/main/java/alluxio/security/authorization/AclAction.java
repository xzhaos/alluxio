/*
 * The Alluxio Open Foundation licenses this work under the Apache License, version 2.0
 * (the "License"). You may not use this work except in compliance with the License, which is
 * available at www.apache.org/licenses/LICENSE-2.0
 *
 * This software is distributed on an "AS IS" basis, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied, as more fully set forth in the License.
 *
 * See the NOTICE file distributed with this work for information regarding copyright ownership.
 */

package alluxio.security.authorization;

import alluxio.proto.journal.File;

/**
 * Actions to be controlled in {@link AccessControlList}.
 */
public enum AclAction {
  READ,
  WRITE,
  EXECUTE;

  /** AclAction values. */
  private static final AclAction[] VALUES = AclAction.values();

  /**
   * @param ordinal the ordinal of the target action in {@link AclAction}
   * @return the {@link AclAction} with the specified ordinal
   * @throws IndexOutOfBoundsException when ordinal is out of range of valid ordinals
   */
  public static AclAction ofOrdinal(int ordinal) {
    return VALUES[ordinal];
  }

  /**
   * @param action the protobuf representation of {@link AclAction}
   * @return the {@link AclAction} decoded from the protobuf representation
   */
  public static AclAction fromProtoBuf(File.AclAction action) {
    switch (action) {
      case READ:
        return READ;
      case WRITE:
        return WRITE;
      case EXECUTE:
        return EXECUTE;
      default:
        throw new IllegalStateException("Unknown protobuf acl action: " + action);
    }
  }

  /**
   * @param action the {@link AclAction}
   * @return the protobuf representation of action
   */
  public static File.AclAction toProtoBuf(AclAction action) {
    switch (action) {
      case READ:
        return File.AclAction.READ;
      case WRITE:
        return File.AclAction.WRITE;
      case EXECUTE:
        return File.AclAction.EXECUTE;
      default:
        throw new IllegalStateException("Unknown acl action: " + action);
    }
  }
}

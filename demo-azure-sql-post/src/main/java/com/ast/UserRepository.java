/*
 *  05-08-2021 
 *  Copyright (c) 2021 AST Corporation. All Rights Reserved.
 *
 *
 *
*/

package com.ast;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author rsuryavanshi
 *
 */
public interface UserRepository extends JpaRepository<User, Long> {

}

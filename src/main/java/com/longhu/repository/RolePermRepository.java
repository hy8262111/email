package com.longhu.repository;

import com.longhu.entity.RolePermission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolePermRepository extends JpaRepository<RolePermission, Integer> {
}

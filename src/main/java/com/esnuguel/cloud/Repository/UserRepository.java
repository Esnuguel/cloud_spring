package com.esnuguel.cloud.Repository;

import org.springframework.stereotype.Repository;

import com.esnuguel.cloud.Models.User;
import com.google.cloud.spring.data.firestore.FirestoreReactiveRepository;

@Repository
public interface UserRepository extends FirestoreReactiveRepository<User> {
    // Custom query methods can be defined here if needed

}

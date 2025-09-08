package com.example.krishichain.data.repository

import com.example.krishichain.data.dao.UserProfileDao
import com.example.krishichain.data.entity.UserProfile

class UserProfileRepository(private val userProfileDao: UserProfileDao) {
    suspend fun insert(profile: UserProfile) = userProfileDao.insert(profile)
    suspend fun getById(id: String) = userProfileDao.getById(id)
}
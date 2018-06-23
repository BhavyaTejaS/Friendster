package com.app.DAO;

import com.app.Models.ProfilePicture;

public interface ProfilePictureDao {
void saveProfilePicture(ProfilePicture profilePicture);
ProfilePicture getProfilePicture(String email); 
}
package com.cesi.library_project.providers;

import com.cesi.library_project.database.controllers.MusicController;
import com.cesi.library_project.database.models.Music;
import com.cesi.library_project.providers.ui.music.MusicForm;
import com.cesi.library_project.providers.ui.music.MusicThumbnail;

public class MusicProvider extends AbstractProvider<Music, MusicThumbnail, MusicController, MusicForm> {
    @Override
    protected MusicController createController() {
        return MusicController.getInstance();
    }

    @Override
    public MusicThumbnail getThumbnailProvider(Music object) {
        return new MusicThumbnail(object);
    }

    @Override
    public MusicThumbnail getPageProvider(Music object) {
        return null;
    }

    @Override
    public MusicForm modifyObject(Music object) {
        return new MusicForm(object);
    }

    @Override
    public MusicForm createObject() {
        return new MusicForm(null);
    }
}

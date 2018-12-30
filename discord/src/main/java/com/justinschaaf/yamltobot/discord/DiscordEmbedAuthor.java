package com.justinschaaf.yamltobot.discord;

/**
 *
 * The author of a Discord embed
 *
 * @author Justin Schaaf
 * @since 3.0.0
 *
 */
public class DiscordEmbedAuthor {

    private String name;
    private String url;
    private String avatar;

    public DiscordEmbedAuthor(String name) {
        this(name, null, null);
    }

    /**
     *
     * The author of a Discord embed
     *
     * @param name The author's name
     * @param url The author's URL. This is required in order for the avatar to work
     * @param avatar The author's avatar.
     * @since 3.0.0
     *
     */
    public DiscordEmbedAuthor(String name, String url, String avatar) {
        this.name = name;
        this.url = url;
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

}

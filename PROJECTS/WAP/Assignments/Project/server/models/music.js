const uuid = require("uuid");

let musicDb = [
    { id: 1, title: '01 - Is This Love', genre: 'POP', publishedDate: '09-11-2007', artist: 'Beyonce' },
    { id: 2, title: '02 - Three Little Birds', genre: 'POP', publishedDate: '09-11-2007', artist: 'Beyonce' },
    { id: 3, title: '03 - Buffalo Soldier', genre: 'POP', publishedDate: '09-11-2007', artist: 'Beyonce' },
    { id: 4, title: '04 - Get Up, Stand Up', genre: 'POP', publishedDate: '09-11-2007', artist: 'Beyonce' },
    { id: 5, title: '05 - Stir It Up', genre: 'POP', publishedDate: '09-11-2007', artist: 'Beyonce' }
];

let authUser = {
    id: 1, username: "Eric" , password:"password", playlist: [1,2,3]
}

module.exports = class Music {

    constructor(id, title, genre, publishedDate, artist) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.publishedDate = publishedDate;
        this.artist = artist;
    }

    static getAll() {
        return musicDb;
    }

    static getPlaylist() {
        return musicDb.filter(mu => authUser.playlist.includes(mu.id));
    }

    static getMusicById(id) {
        const music = musicDb.find(b => b.id === id);
        if (music) {
            return music;
        } else {
            throw new Error(`No music found with Id: ${id}`);
        }
    }

    static addToPlaylist(id) {
        authUser.playlist.push(id);
        const music = musicDb.find(b => b.id === id);
        if (music) {
            return music;
        } else {
            throw new Error(`No music found with Id: ${id}`);
        }  
    }

    static deleteFromPlaylist = (id) => {
        
        const index = authUser.playlist.findIndex(b => b === id);
        if (index > -1) {
            
            authUser.playlist.splice(index, 1);
            const mus = musicDb.find(m => m.id == id);
            return mus;
        } else {
            throw new Error(`No book found with Id: ${id}`);
        }
    }

    save() {
        this.id = uuid.v4();
        musicDb.push(this);
        return this;
    }

    static deleteById(id) {
        const index = musicDb.findIndex(b => b.id === id);
        if (index > -1) {
          
            const temp = books[index];
            musicDb.splice(index, 1);
            return temp;
        } else {
            throw new Error(`No book found with Id: ${id}`);
        }
    }

    update(id) {
        const index = musicDb.findIndex(p => p.id === id);
        if (index > -1) {
            this.id = id;
            musicDb[index] = this;
        } else {
            throw new Error(`No book found with Id: ${id}`);
        }
    }

}
package com.example.moviesapp.data.datasource.cache.impl

import com.example.moviesapp.data.datasource.cache.CacheDataSource
import com.example.moviesapp.data.model.dto.InteractionDTO
import com.example.moviesapp.data.model.dto.MovieDTO
import com.example.moviesapp.domain.model.InteractionModel
import javax.inject.Inject

class CacheDataSourceImpl @Inject constructor():CacheDataSource {
    override fun getMovies(): List<MovieDTO> {
        return listOf(
            MovieDTO("Doctor Strange in the Multiverse of Madness","2022","Benedict Cumberbatch, Elizabeth Olsen", 3.6, "Doctor Strange, with the help of mystical allies both old and new, traverses the mind-bending and dangerous alternate realities of the Multiverse to confront a mysterious new adversary.", "Fantasy","https://www.themoviedb.org/t/p/w600_and_h900_bestv2/wRnbWt44nKjsFPrqSmwYki5vZtF.jpg", "https://www.youtube.com/watch?v=Rt_UqUm38BI"),
            MovieDTO("Morbius","2022","Jared Leto, Matt Smith, Adria Arjona", 3.1, "Dangerously ill with a rare blood disorder, and determined to save others suffering his same fate, Dr. Michael Morbius attempts a desperate gamble. What at first appears to be a radical success soon reveals itself to be a remedy potentially worse than the disease.", " Science Fiction", "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/6JjfSchsU6daXk2AKX8EEBjO3Fm.jpg", "https://www.youtube.com/watch?v=jLMBLuGJTsA"),
            MovieDTO("Spider-Man: No Way Home","2021","Tom Holland, Zendaya",4.1, "Peter Parker is unmasked and no longer able to separate his normal life from the high-stakes of being a super-hero. When he asks for help from Doctor Strange the stakes become even more dangerous, forcing him to discover what it truly means to be Spider-Man.", " Science Fiction", "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/1g0dhYtq4irTY1GPXvft6k4YLjm.jpg","https://www.youtube.com/watch?v=rt-2cxAiPJk"),
            MovieDTO("Demon Slayer -Kimetsu no Yaiba- The Movie: Mugen Train","2020","Natsuki Hanae, Akari Kito, Hiro Shimono", 4.1, "Tanjirō Kamado, joined with Inosuke Hashibira, a boy raised by boars who wears a boar's head, and Zenitsu Agatsuma, a scared boy who reveals his true power when he sleeps, boards the Infinity Train on a new mission with the Fire Hashira, Kyōjurō Rengoku, to defeat a demon who has been tormenting the people and killing the demon slayers who oppose it!", "Animation","https://www.themoviedb.org/t/p/w600_and_h900_bestv2/h8Rb9gBr48ODIwYUttZNYeMWeUU.jpg", "https://www.youtube.com/watch?v=ATJYac_dORw"),
            MovieDTO("Dune","2021","Timothée Chalamet, Rebecca Ferguson",3.9, "Paul Atreides, a brilliant and gifted young man born into a great destiny beyond his understanding, must travel to the most dangerous planet in the universe to ensure the future of his family and his people. As malevolent forces explode into conflict over the planet's exclusive supply of the most precious resource in existence-a commodity capable of unlocking humanity's greatest potential-only those who can conquer their fear will survive.", "Adventure", "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/d5NXSklXo0qyIYkgV94XAgMIckC.jpg", "https://www.youtube.com/watch?v=n9xhJrPXop4"),
            MovieDTO("The Maze Runner","2014","Dylan O'Brien, Kaya Scodelario",3.5, "Set in a post-apocalyptic world, young Thomas is deposited in a community of boys after his memory is erased, soon learning they're all trapped in a maze that will require him to join forces with fellow “runners” for a shot at escape.", "Thriller", "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/ode14q7WtDugFDp78fo9lCsmay9.jpg", "https://www.youtube.com/watch?v=64-iSYVmMVY")
        )
    }

    override fun getInteractions():List<InteractionDTO> {
        return listOf(
            InteractionDTO("Calificaciones","Calificar y obtener recomendaciones",0),
            InteractionDTO("Listas","Agregar a listas",4),
            InteractionDTO("Comentarios","Agregar comentarios",0)
        )
    }

}
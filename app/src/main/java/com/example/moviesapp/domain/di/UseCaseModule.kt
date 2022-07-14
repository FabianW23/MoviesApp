package com.example.moviesapp.domain.di

import com.example.moviesapp.domain.usecase.interaction.GetInteractionsUseCase
import com.example.moviesapp.domain.usecase.movie.GetMoviesUseCase
import com.example.moviesapp.domain.usecase.movie.GetTopRatedMoviesUseCase
import com.example.moviesapp.domain.usecase.authentication.RegisterUserUseCase
import com.example.moviesapp.domain.usecase.authentication.SelectUserByEmailUseCase
import com.example.moviesapp.domain.usecase.authentication.SelectUserUseCase
import com.example.moviesapp.domain.usecase.interaction.impl.GetInteractionsUseCaseImpl
import com.example.moviesapp.domain.usecase.movie.impl.GetMoviesUseCaseImpl
import com.example.moviesapp.domain.usecase.movie.impl.GetTopRatedMoviesUseCaseImpl
import com.example.moviesapp.domain.usecase.authentication.impl.RegisterUserUseCaseImpl
import com.example.moviesapp.domain.usecase.authentication.impl.SelectUserByEmailUseCaseImpl
import com.example.moviesapp.domain.usecase.authentication.impl.SelectUserUseCaseImpl
import com.example.moviesapp.domain.usecase.string.ClearStringsUseCase
import com.example.moviesapp.domain.usecase.string.GetStringUseCase
import com.example.moviesapp.domain.usecase.string.PutStringUseCase
import com.example.moviesapp.domain.usecase.string.impl.ClearStringsUseCaseImpl
import com.example.moviesapp.domain.usecase.string.impl.GetStringUseCaseImpl
import com.example.moviesapp.domain.usecase.string.impl.PutStringUseCaseImpl
import com.example.moviesapp.domain.usecase.validation.ValidateEmailFieldUseCase
import com.example.moviesapp.domain.usecase.validation.ValidateEmptyFieldUseCase
import com.example.moviesapp.domain.usecase.validation.ValidatePasswordFieldUseCase
import com.example.moviesapp.domain.usecase.validation.impl.ValidateEmailFieldUseCasedImpl
import com.example.moviesapp.domain.usecase.validation.impl.ValidateEmptyFieldUseCaseImpl
import com.example.moviesapp.domain.usecase.validation.impl.ValidatePasswordFieldUseCasedImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class UseCaseModule {

    @Binds
    @Singleton
    abstract fun bindGetMoviesUseCase(getMoviesUseCaseImpl: GetMoviesUseCaseImpl) : GetMoviesUseCase

    @Binds
    @Singleton
    abstract fun bindGetTopRatedMoviesUseCase(getTopRatedMoviesUseCaseImpl: GetTopRatedMoviesUseCaseImpl) : GetTopRatedMoviesUseCase

    @Binds
    @Singleton
    abstract fun bindGetInteractionsUseCase(getInteractionsUseCaseImpl: GetInteractionsUseCaseImpl): GetInteractionsUseCase

    @Binds
    @Singleton
    abstract fun bindRegisterUserUseCase(registerUserUseCaseImpl: RegisterUserUseCaseImpl): RegisterUserUseCase

    @Binds
    @Singleton
    abstract fun bindSelectUserUseCase(selectUserUseCaseImpl: SelectUserUseCaseImpl): SelectUserUseCase

    @Binds
    @Singleton
    abstract fun bindSelectUserByEmailUseCase(selectUserByEmailUseCaseImpl: SelectUserByEmailUseCaseImpl) : SelectUserByEmailUseCase

    @Binds
    @Singleton
    abstract fun bindValidateEmptyFieldUseCase(validateEmptyFieldUseCaseImpl: ValidateEmptyFieldUseCaseImpl) : ValidateEmptyFieldUseCase

    @Binds
    @Singleton
    abstract fun bindValidatePasswordFieldUseCase(validatePasswordFieldUseCasedImpl: ValidatePasswordFieldUseCasedImpl) : ValidatePasswordFieldUseCase

    @Binds
    @Singleton
    abstract fun bindValidateEmailFieldUseCase(validateEmailFieldUseCasedImpl: ValidateEmailFieldUseCasedImpl) : ValidateEmailFieldUseCase

    @Binds
    @Singleton
    abstract fun bindGetStringUseCase(getStringUseCaseImpl: GetStringUseCaseImpl): GetStringUseCase

    @Binds
    @Singleton
    abstract fun bindPutStringUseCase(putStringUseCaseImpl: PutStringUseCaseImpl):PutStringUseCase

    @Binds
    @Singleton
    abstract fun bindClearStringsUseCase(clearStringsUseCaseImpl: ClearStringsUseCaseImpl):ClearStringsUseCase
}

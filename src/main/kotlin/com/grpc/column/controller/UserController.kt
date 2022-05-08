package com.grpc.column.controller

import com.kotlingrpc.proto.UserProvider
import com.kotlingrpc.proto.UserServiceGrpcKt
import org.lognet.springboot.grpc.GRpcService

@GRpcService
class UserController : UserServiceGrpcKt.UserServiceCoroutineImplBase() {

    /**
     * ユーザー取得
     */
    override suspend fun getUser(request: UserProvider.GetUserRequest): UserProvider.GetUserResponse {
        return UserProvider.GetUserResponse.newBuilder().setMail(fetchMail(request.id)).build()
    }

    /**
     * メールアドレスを返す
     */
    private fun fetchMail(id: Int) = when (id) {
        1 -> "video@videomarket.co.jp"
        2 -> "market@videomarket.co.jp"
        else -> ""
    }
}

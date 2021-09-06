package ru.axout.mvvm_colorguide.network;

import androidx.annotation.NonNull;
import retrofit2.Callback;
import retrofit2.Response;

public class Call {

    private final Delegate delegate;

    public Call(Delegate delegate) {
        this.delegate = delegate;
    }

    public void execute() {
        // формируем запрос
        ICall callInterface = Api.getClient().create(ICall.class);
        // "подставляем" GET запрос к базовому URL
        retrofit2.Call<FlowerResponse> call = callInterface.getAllFlowers();
        // выполняем запрос и ожидаем ответ с сервера
        call.enqueue(new Callback<FlowerResponse>() {
            // если ответ получен, и если код ответа ожидаемый, то вызываем метод onSuccess() и передаём туда данные
            @Override
            public void onResponse(@NonNull retrofit2.Call<FlowerResponse> call,
                                   @NonNull Response<FlowerResponse> response) {
                int statusCode = response.code();
                if (statusCode == Config.RESP_OK) delegate.onSuccess(response.body()); // onSuccess(); переопределяется в FlowersActivity
                else delegate.onFailure("On failure - " + statusCode);
            }
            // а если ответа нет, или ответ некорректный, то выводим сообщение с ошибкой
            @Override
            public void onFailure(@NonNull retrofit2.Call<FlowerResponse> call,
                                  @NonNull Throwable t) {
                delegate.onFailure(t.getMessage()); // onFailure(); переопределяется в FlowersActivity
            }
        });
    }

    public interface Delegate {
        void onSuccess(FlowerResponse flowerResponse);
        void onFailure(Object t);
    }
}

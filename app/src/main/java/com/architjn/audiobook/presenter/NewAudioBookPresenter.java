package com.architjn.audiobook.presenter;

import android.content.Context;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.architjn.audiobook.adapter.AudioBookAdapter;
import com.architjn.audiobook.adapter.IAdapterItemClick;
import com.architjn.audiobook.bean.AudioBook;
import com.architjn.audiobook.interactor.NewAudioBookInteractor;
import com.architjn.audiobook.presenter.interfaces.IAllAudioBookPresenter;
import com.architjn.audiobook.ui.IAudioBookView;
import com.architjn.audiobook.utils.PrefUtils;

import java.util.ArrayList;

/**
 * Created by HP on 23-07-2017.
 */

public class NewAudioBookPresenter implements IAdapterItemClick<AudioBook>, IAllAudioBookPresenter {
    private final PrefUtils pref;
    private final NewAudioBookInteractor interactor;
    private IAudioBookView view;
    private Context context;
    private AudioBookAdapter adapter;

    public NewAudioBookPresenter(Context context, IAudioBookView view) {
        this.view = view;
        this.context = context;
        this.pref = PrefUtils.getInstance(context);
        this.interactor = new NewAudioBookInteractor(context, this);
    }

    public void setRecycler(RecyclerView rv) {
        LinearLayoutManager lm = new LinearLayoutManager(context);
        rv.setLayoutManager(lm);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(rv.getContext(),
                lm.getOrientation());
        rv.addItemDecoration(dividerItemDecoration);
        ArrayList<AudioBook> items = new ArrayList<>();
        adapter = new AudioBookAdapter(context, items, this);
        rv.setAdapter(adapter);
        interactor.loadNewAudioBooks();
    }

    @Override
    public void onItemSelected(int position, AudioBook item) {
        interactor.markAudioBookOnGoing(item);
    }

    @Override
    public void onAudioBooksLoaded(ArrayList<AudioBook> books) {
        if (adapter != null)
            adapter.updateList(books);
    }

    public void updateBookList() {
        interactor.loadNewAudioBooks();
    }
}

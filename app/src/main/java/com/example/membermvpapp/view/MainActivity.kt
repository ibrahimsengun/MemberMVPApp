package com.example.membermvpapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.recyclerview.widget.RecyclerView
import com.example.membermvpapp.contract.MainActivityContract
import com.example.membermvpapp.R
import com.example.membermvpapp.model.Member
import com.example.membermvpapp.presenter.MainActivityPresenter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),
    MainActivityContract.View {

    private lateinit var mPresenter: MainActivityContract.Presenter

    private lateinit var searchBox: AppCompatEditText
    private lateinit var btnAddMember: AppCompatButton
    private lateinit var memberListView: ListView

    private val members = arrayListOf<Member>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.mPresenter = MainActivityPresenter(members)
        this.mPresenter.setView(this)
        this.mPresenter.created()
    }

    override fun bindViews() {
        this.btnAddMember = findViewById(R.id.addMember)
        this.memberListView = findViewById(R.id.memberList)
        this.searchBox = findViewById(R.id.search)
    }

    override fun initOnClicks() {
        this.btnAddMember.setOnClickListener{
            this.mPresenter.onBtnAddMember()
        }
    }
    override fun initView() {
        val array = arrayListOf<String>()
        for (i in members.indices) {
            array.add(members[i].name)
        }
        val adapter:ArrayAdapter<String> = ArrayAdapter(this, android.R.layout.simple_list_item_1, array)
        memberListView.adapter = adapter

        this.searchBox.addTextChangedListener(object: TextWatcher {
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                adapter.filter.filter(s.toString())
            }
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }
        })
    }
}

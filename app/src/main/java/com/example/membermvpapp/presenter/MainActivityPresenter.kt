package com.example.membermvpapp.presenter

import com.example.membermvpapp.contract.MainActivityContract
import com.example.membermvpapp.model.Member

class MainActivityPresenter(members: ArrayList<Member>) : MainActivityContract.Presenter {

    private lateinit var  mView: MainActivityContract.View
    private val memberArray: ArrayList<Member> = members

    private fun init(){
        memberArray.add(Member("Yasin Cetiner", 30, "Istanbul", "artizco", "Android Developer", 2))
        memberArray.add(Member("Tolga Can Unal", 25, "Istanbul", "tolgacanunal", "Android Developer", 2))
        memberArray.add(Member("Mithat Sinan Sari", 26, "Istanbul", "mitsinsar", "Android Developer", 1))
        this.mView.initView()
    }

    override fun setView(view: MainActivityContract.View) {
        this.mView = view
    }

    override fun created() {
        this.mView.bindViews()
        this.mView.initOnClicks()
        this.init()
    }

    override fun onBtnAddMember() {
        val ibrahimsengun = Member("Ibrahim Sengun", 21, "Malatya", "ibrahimsengun", "Intern", 0)
        if (!memberArray.contains(ibrahimsengun))
            memberArray.add(ibrahimsengun)
        this.mView.initView()
    }
}
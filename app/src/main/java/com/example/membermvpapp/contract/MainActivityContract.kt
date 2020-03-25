package com.example.membermvpapp.contract

interface MainActivityContract {

    interface View{
        fun bindViews()
        fun initOnClicks()
        fun initView()
    }

    interface Presenter{
        fun setView(view: View)
        fun created()
        fun onBtnAddMember()
    }
}
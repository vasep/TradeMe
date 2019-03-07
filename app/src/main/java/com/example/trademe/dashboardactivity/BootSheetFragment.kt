package com.example.trademe.dashboardactivity

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.design.widget.BottomSheetDialogFragment
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.trademe.R
import kotlinx.android.synthetic.main.fragment_boot_sheet.*
import kotlinx.android.synthetic.main.fragment_boot_sheet.view.*
import java.lang.ClassCastException

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [BootSheetFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [BootSheetFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class BootSheetFragment : BottomSheetDialogFragment(){

    private var mBottomSheetListerner : BottomSheetListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val v =inflater.inflate(R.layout.bottom_alert_layout, container, false)

        v.lt_Clothes.setOnClickListener{
            mBottomSheetListerner!!.onOptionClick()
            dismiss()
        }
        v.lt_Books.setOnClickListener{
            mBottomSheetListerner!!.onOptionClick()
            dismiss()
        }
       v.lt_Other.setOnClickListener{
            mBottomSheetListerner!!.onOptionClick()
           dismiss()

       }

        return v
    }

    interface BottomSheetListener {
        fun onOptionClick()
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)

        try{
            mBottomSheetListerner=context as BottomSheetListener
        }catch (e : ClassCastException){
            throw ClassCastException(context!!.toString())
        }



    }
}

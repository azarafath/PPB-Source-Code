package id.my.zakariafathoni.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.fragment.app.DialogFragment


class OptionDialogFragment : DialogFragment(){

    private lateinit var btnChoose: Button
    private lateinit var btnClose: Button
    private lateinit var rgOptions: RadioGroup
    private lateinit var rbBr: RadioButton
    private lateinit var rbPoc: RadioButton
    private lateinit var rbRang: RadioButton
    private lateinit var rbHag: RadioButton
    private var optionDialogListener: OnOptionDialogListener? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_option_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnChoose = view.findViewById(R.id.btn_choose)
        btnClose = view.findViewById(R.id.btn_close)
        rgOptions = view.findViewById(R.id.rg_options)
        rbBr = view.findViewById(R.id.rb_br)
        rbPoc = view.findViewById(R.id.rb_poc)
        rbRang = view.findViewById(R.id.rb_rang)
        rbHag = view.findViewById(R.id.rb_hag)

        btnChoose.setOnClickListener {
            val checkedRadioButtonId = rgOptions.checkedRadioButtonId
            if (checkedRadioButtonId != -1) {
                var coach: String? = null
                when (checkedRadioButtonId) {
                    R.id.rb_br -> coach = rbBr.text.toString().trim()
                    R.id.rb_poc -> coach = rbPoc.text.toString().trim()
                    R.id.rb_rang -> coach = rbRang.text.toString().trim()
                    R.id.rb_hag -> coach = rbHag.toString().trim()
                }
                optionDialogListener?.onOptionChosen(coach)
                dialog?.dismiss()
            }
        }
        btnClose.setOnClickListener {
            dialog?.cancel()
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val fragment = parentFragment
        if (fragment is DetailCategoryFragment) {
            this.optionDialogListener = fragment.optionDialogListener
        }
    }

    override fun onDetach() {
        super.onDetach()
        this.optionDialogListener = null
    }

    interface OnOptionDialogListener {
        fun onOptionChosen(text: String?)
    }
}
//package uz.gita.luis.broadcast.presentation.dialogs
//
//import android.graphics.Color
//import android.graphics.drawable.ColorDrawable
//import android.os.Bundle
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import by.kirich1409.viewbindingdelegate.viewBinding
//import com.google.android.material.bottomsheet.BottomSheetDialog
//import com.google.android.material.bottomsheet.BottomSheetDialogFragment
//import uz.gita.luis.broadcast.R
//import uz.gita.luis.broadcast.databinding.DialogBottomBinding
//
//
//class MyBottomSheetDialog:BottomSheetDialog() {
//    private val binding by viewBinding(DialogBottomBinding::bind)
//
//    private var onClickShareListener: (() -> Unit)? = null
//    private var onClickRateListener: (() -> Unit)? = null
//    private var onClickFeedbackListener: (() -> Unit)? = null
//
//
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
////        dialog!!.window!!.setBackgroundDrawableResource(android.R.color.transparent)
////        dialog!!.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
//    }
//
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        return inflater.inflate(R.layout.dialog_bottom, container, false)
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//
//        dialog!!.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
//        dialog!!.window!!.setBackgroundDrawableResource(android.R.color.transparent)
//        binding.shareApp.setOnClickListener {
//            onClickShareListener?.invoke()
//            dismiss()
//        }
//        binding.rateApp.setOnClickListener {
//            onClickRateListener?.invoke()
//            dismiss()
//        }
//        binding.feedback.setOnClickListener {
//            onClickFeedbackListener?.invoke()
//            dismiss()
//        }
//    }
//
//    fun setOnClickShareListener(block: () -> Unit) {
//        onClickShareListener = block
//    }
//
//    fun setOnClickRateListener(block: () -> Unit) {
//        onClickRateListener = block
//    }
//
//    fun setOnClickFeedbackListener(block: () -> Unit) {
//        onClickFeedbackListener = block
//    }
//}
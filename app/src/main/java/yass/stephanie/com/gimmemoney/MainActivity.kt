package yass.stephanie.com.gimmemoney

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomsheet.BottomSheetDialog

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val continueTextView: TextView = findViewById(R.id.continue_button)
        continueTextView.setOnClickListener {
            var dialog = BottomSheetDialog(this, android.R.style.Theme_Black_NoTitleBar)
            setUpConfirmTransferDialog(dialog)
        }
    }

    private fun confirmTransferListener(dialog: BottomSheetDialog): View.OnClickListener =
        View.OnClickListener {
            val transferAnimationView: View? =
                dialog.findViewById(R.id.transfer_loading_animation)
            transferAnimationView?.apply {
                visibility = View.VISIBLE
                bringToFront()
            }
        }

    private fun setUpConfirmTransferDialog(dialog: BottomSheetDialog) {
        dialog.apply {
            window?.apply {
                setBackgroundDrawable(ColorDrawable(Color.argb(100, 0, 0, 0)))
                setWindowAnimations(R.style.DialogAnimation)
            }
            setContentView(R.layout.confirm_money_dialog)
            setCancelable(true)
            setCanceledOnTouchOutside(true)
            show()

            val confirmTransferText: TextView? = dialog.findViewById(R.id.complete_transfer_button)
            confirmTransferText?.setOnClickListener { confirmTransferListener(dialog) }
        }

    }
}




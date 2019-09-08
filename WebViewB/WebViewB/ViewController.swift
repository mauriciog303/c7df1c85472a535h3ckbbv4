//
//  ViewController.swift
//  WebViewB
//
//  Created by Raymundo Muñoz on 9/7/19.
//  Copyright © 2019 Raymundo Muñoz. All rights reserved.
//

import UIKit
import WebKit

class ViewController: UIViewController {

    @IBOutlet weak var webView: WKWebView!
    
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        let url = URL(string: "https://mauriciog303.github.io/hackbbva2019/")
        let request = URLRequest(url: url!)
        
        webView.load(request)
    }


}

